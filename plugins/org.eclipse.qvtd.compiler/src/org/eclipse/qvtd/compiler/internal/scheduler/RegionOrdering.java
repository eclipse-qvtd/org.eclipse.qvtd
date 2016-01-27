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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.NameUtil;

import com.google.common.collect.Iterables;

/**
 * The RegionOrdering computes an ordering of the regions such that the sources of mandatory access dependencies precede their targets
 * and where possible the sources of preferred dependencies precede their targets.
 */
public class RegionOrdering
{
	private final @NonNull Region2Depth region2depth;
	/**
	 * Cached list of all incoming connections per-region; excludes recursions.
	 */
	private final @NonNull Map<Region, @NonNull List<Connection>> region2incomingConnections = new HashMap<Region, @NonNull List<Connection>>();

	/**
	 * Cached list of all recursive/looping connections per-region.
	 */
	private final @NonNull Map<Region, @NonNull List<Connection>> region2loopingConnections = new HashMap<Region, @NonNull List<Connection>>();

	/**
	 * Cached list of all outgoing connections per-region; excludes recursions.
	 */
	private final @NonNull Map<Region, @NonNull List<Connection>> region2outgoingConnections = new HashMap<Region, @NonNull List<Connection>>();

	/**
	 * Cached list of all source regions per-connection.
	 */
	private final @NonNull Map<Connection, @NonNull List<Region>> connection2sourceRegions = new HashMap<Connection, @NonNull List<Region>>();

	/**
	 * Cached list of all target regions per-connection.
	 */
	private final @NonNull Map<Connection, @NonNull List<Region>> connection2targetRegions = new HashMap<Connection, @NonNull List<Region>>();
	
	/**
	 * The connections that are not passed to any regions.
	 */
	private final @NonNull Set<Connection> unpassedConnections = new HashSet<Connection>();
	
	/**
	 * Working state: the schedulables that have been ordered.
	 */
	private final @NonNull List<Schedulable> orderedSchedulables = new ArrayList<Schedulable>();
	
	/**
	 * Working state: the regions that have not yet been ordered but which are no longer blocked.
	 */
	private final @NonNull Set<Region> unblockedRegions = new HashSet<Region>();
	
	/**
	 * Working state: the regions that have not yet been ordered but which are blocked by a mandatory access.
	 */
	private final @NonNull Set<Region> mandatoryBlockedRegions = new HashSet<Region>();
	
	/**
	 * Working state: the regions that have not yet been ordered but which are blocked by a preferred access.
	 */
	private final @NonNull Set<Region> preferredBlockedRegions = new HashSet<Region>();
	
	/**
	 * Working state: connections that block a region.
	 */
	private final @NonNull Set<Connection> blockedConnections = new HashSet<Connection>();
	
	/**
	 * Working state: call stack to access current region.
	 */
	private final @NonNull Stack<Region> callStack = new Stack<Region>();
	
	/**
	 * Working state: the common region for all uses of each connection.
	 */
	private final @NonNull Map<Connection, Region> connection2commonRegion = new HashMap<Connection, Region>();
	
	public RegionOrdering(@NonNull Region2Depth region2depth, @NonNull Iterable<Region> regions) {
		this.region2depth = region2depth;
		for (Region region : regions) {
			if (region.isOperationRegion()) {
				continue;
			}
			List<Connection> incomingConnections = new ArrayList<Connection>();
			List<Connection> loopingConnections = new ArrayList<Connection>();
			List<Connection> outgoingConnections = new ArrayList<Connection>();
			for (Connection connection : region.getParentConnections()) {
				for (Node source : connection.getSources()) {
					if ((region != source.getRegion()) && !incomingConnections.contains(connection)) {
						incomingConnections.add(connection);
					}
				}
			}
			for (Connection connection : region.getChildConnections()) {
				for (Node target : connection.getTargets()) {
					if (!outgoingConnections.contains(connection)) {
						if (region == target.getRegion()) {
							loopingConnections.add(connection);
						}
						else {
							outgoingConnections.add(connection);
						}
					}
				}
			}
			if (outgoingConnections.size() > 1) {			// Ensure that connection ordering is deterministic
				Collections.sort(outgoingConnections, NameUtil.NAMEABLE_COMPARATOR);
			}
			region2incomingConnections.put(region, incomingConnections);
			region2loopingConnections.put(region, loopingConnections);
			region2outgoingConnections.put(region, outgoingConnections);
			if (incomingConnections.isEmpty()) {
				assert !orderedSchedulables.contains(region);
				unblockedRegions.add(region);
			}
			else {
				boolean hasMandatoryUsedConnection = false;
				for (Connection connection : incomingConnections) {
					blockedConnections.add(connection);
					if (connection.isMandatory()) {
						hasMandatoryUsedConnection = true;
					}
					if (!connection.isPassed()) {
						unpassedConnections.add(connection);
					}
					List<Region> sourceRegions = connection2sourceRegions.get(connection);
					if (sourceRegions == null) {
						sourceRegions = new ArrayList<Region>();
						for (Node sourceNode : connection.getSources()) {
							Region sourceRegion = sourceNode.getRegion();
							if (!sourceRegions.contains(sourceRegion)) {
								sourceRegions.add(sourceRegion);
							}
						}
						connection2sourceRegions.put(connection, sourceRegions);
					}
					List<Region> targetRegions = connection2targetRegions.get(connection);
					if (targetRegions == null) {
						targetRegions = new ArrayList<Region>();
						for (Node targetNode : connection.getTargets()) {
							Region targetRegion = targetNode.getRegion();
							if (!targetRegions.contains(targetRegion)) {
								targetRegions.add(targetRegion);
							}
						}
						connection2targetRegions.put(connection, targetRegions);
					}
				}
				if (hasMandatoryUsedConnection) {
					mandatoryBlockedRegions.add(region);
				}
				else {
					preferredBlockedRegions.add(region);
				}
			}
		}
	}

	/**
	 * Return an ordered list of regions that respects all mandatory accesses and many preferred accesses.
	 */
	public @NonNull List<Schedulable> computeOrdering() {
		while ((unblockedRegions.size() > 0) || (preferredBlockedRegions.size() > 0)) {
			//
			//	Pick a region to execute.
			//
			Region selectedRegion = selectNextRegion();
			assert selectedRegion != null;
			//
			int index = orderedSchedulables.size();
			boolean alreadyIndexed = orderedSchedulables.contains(selectedRegion);
			if (!alreadyIndexed) {
				Scheduler.REGION_ORDER.println(index + " : " + selectedRegion);
				selectedRegion.setIndexes(index, index);
			}
			else {
				int earliestIndex = selectedRegion.getEarliestIndex();
				for (int i = earliestIndex; i < index; i++) {
					Scheduler.REGION_ORDER.println(i + " ... " + index + " : " + selectedRegion);
					orderedSchedulables.get(i).setIndexes(i, index);
				}
			}
			orderedSchedulables.add(selectedRegion);
			boolean wasRemoved1 = unblockedRegions.remove(selectedRegion);
			boolean wasRemoved2 = preferredBlockedRegions.remove(selectedRegion);
			assert wasRemoved1 || wasRemoved2;
			//
			//	Unblock connections whose final blocking source is the selectedRegion.
			//
//			assert !alreadyIndexed;
			List<Connection> loopingConnections = region2loopingConnections.get(selectedRegion);
			List<Connection> outgoingConnections = region2outgoingConnections.get(selectedRegion);
			assert loopingConnections != null;
			assert outgoingConnections != null;
			Set<Region> nextRegions = new HashSet<Region>();
			for (@SuppressWarnings("null")@NonNull Connection outgoingConnection : Iterables.concat(loopingConnections, outgoingConnections)) {
				if (refreshConnectionBlockage(outgoingConnection)) {
					if (!orderedSchedulables.contains(outgoingConnection)) {			// re-unblocking can occur when multiple regions are unblocked at once
						int size = orderedSchedulables.size();
						Scheduler.REGION_ORDER.println(size + " : " + outgoingConnection);
						outgoingConnection.setIndexes(size, size);
						orderedSchedulables.add(outgoingConnection);
						List<Region> targetRegions = connection2targetRegions.get(outgoingConnection);
						if (targetRegions != null) {
							nextRegions.addAll(targetRegions);
						}
					}
				}
			}
			//
			//	Unblock regions whose source connections were unblocked.
			//
			for (@SuppressWarnings("null")@NonNull Region nextRegion : nextRegions) {
				refreshRegionBlockage(nextRegion);
			}
			updateCallStack(selectedRegion);
		}
		installConnections();
		return orderedSchedulables;
	}

//	public @NonNull Region getRootRegion() {
//		Schedulable schedulable = orderedSchedulables.get(0);
//		assert schedulable != null;
//		return (Region) schedulable;
//	}

	/**
	 * Install all connections in their common region and any intermediate regions through which propagation is required.
	 */
	private void installConnections() {
		for (@SuppressWarnings("null")@NonNull Connection connection : connection2commonRegion.keySet()) {
			if (connection.isPassed()) {
				Region commonRegion = connection2commonRegion.get(connection);
				assert commonRegion != null;
				List<Region> intermediateRegions = new ArrayList<Region>();
				List<Region> sourceRegions = connection2sourceRegions.get(connection);
				assert sourceRegions != null;
				for (@SuppressWarnings("null")@NonNull Region sourceRegion : sourceRegions) {
					if (sourceRegion != commonRegion) {
						@NonNull List<Region> sourceRegionList = Collections.singletonList(sourceRegion);
						installIntermediateConnections(intermediateRegions, sourceRegionList, commonRegion);
					}
				}
				List<Region> targetRegions = connection2targetRegions.get(connection);
				assert targetRegions != null;
				for (@SuppressWarnings("null")@NonNull Region targetRegion : targetRegions) {
					if ((targetRegion != commonRegion) && connection.isPassed(targetRegion)) {
						installIntermediateConnections(intermediateRegions, targetRegion.getCallableParents(), commonRegion);
					}
				}
				connection.setCommonRegion(commonRegion, intermediateRegions);
				Scheduler.REGION_LOCALITY.println(connection + " => " + commonRegion + " " + intermediateRegions);
			}
		}
		for (@SuppressWarnings("null")@NonNull Connection connection : connection2commonRegion.keySet()) {
			if (connection.isPassed()) {
				Region commonRegion = connection.getCommonRegion();
				assert commonRegion != null;
				List<Region> intermediateRegions = connection.getIntermediateRegions();
				for (@SuppressWarnings("null")@NonNull Region intermediateRegion : intermediateRegions) {
					assert region2depth.getCommonRegion(commonRegion, intermediateRegion) == commonRegion;
				}
			}
		}
	}

	private void installIntermediateConnections(@NonNull List<Region> intermediateRegions, @NonNull Iterable<Region> callableParents, @NonNull Region commonRegion) {
		for (Region callableParent : callableParents) {
			if (callableParent != commonRegion) {
				intermediateRegions.add(callableParent);
				installIntermediateConnections(intermediateRegions, callableParent.getCallableParents(), commonRegion);
			}
		}
	}

	/**
	 * Mark all connections as unblocked as a consequence of the source region being unblocked.
	 * Returns true if the connection is unblocked, false if still blocked.
	 */
	protected boolean refreshConnectionBlockage(@NonNull Connection connection) {
		if (blockedConnections.contains(connection)) { 			// re-unblocking can occur when multiple regions are unblocked at once
			List<Region> sourceRegions = connection2sourceRegions.get(connection);
			assert sourceRegions != null;
			for (Region region : sourceRegions) {
				if (preferredBlockedRegions.contains(region) || mandatoryBlockedRegions.contains(region) || unblockedRegions.contains(region)) {  // Must not unblock connection before region ordered
					return false;
				}
			}
			Scheduler.REGION_ORDER.println("      unblock " + connection); 
			boolean wasRemoved = blockedConnections.remove(connection);
			assert wasRemoved;
		}
		return true;
	}

	/**
	 * Update the state of region following the unblocking of one of its incoming connections.
	 */
	protected boolean refreshRegionBlockage(@NonNull Region region) {
//		assert !orderedRegions.contains(region);		-- may be violated if scheduled despite preferredBlock
		boolean isBlocked = false;
		boolean isMandatoryBlocked = false;
		List<Connection> incomingConnections = region2incomingConnections.get(region);
		assert incomingConnections != null;
		for (Connection connection : incomingConnections) {
			if (blockedConnections.contains(connection)) {
				isBlocked = true;
				if (connection.isMandatory()) {
					isMandatoryBlocked = true;
				}
			}
		}
		if (!isBlocked) {
			if (!unblockedRegions.contains(region)) {
				unblockedRegions.add(region);
			}
			mandatoryBlockedRegions.remove(region);
			preferredBlockedRegions.remove(region);
		}
		else if (!isMandatoryBlocked) {
			mandatoryBlockedRegions.remove(region);
		}
		return isBlocked;
	}

	/**
	 * Select the next region to be scheduled, preferring those that require no work or
	 * at least minimal violation of preferred blockages.
	 */
	protected Region selectNextRegion() {
		if (Scheduler.REGION_ORDER.isActive()) {
			Scheduler.REGION_ORDER.println("      unblocked:"); 
			for (Region region : unblockedRegions) {
				Scheduler.REGION_ORDER.println("        " + region); 
			}
			Scheduler.REGION_ORDER.println("      preferred blocked:"); 
			for (Region region : preferredBlockedRegions) {
				Scheduler.REGION_ORDER.println("        " + region);
				for (Connection connection : region.getParentConnections()) {
					boolean isMandatory = connection.isMandatory();
					boolean isBlocked = blockedConnections.contains(connection);
					Scheduler.REGION_ORDER.println("          "
							+ (isMandatory ? "«mandatory» " : "")
							+ (isBlocked ? "«blocked» " : "")
							+ connection.getSourceDisplayNames());
				}
			}
			Scheduler.REGION_ORDER.println("      mandatory blocked:"); 
			for (Region region : mandatoryBlockedRegions) {
				Scheduler.REGION_ORDER.println("        " + region); 
			}
		}
		//
		//	Select an unblock region
		//
		if (unblockedRegions.size() > 0) {		// FIXME deepest compatible with current context
			List<Region> sorted = new ArrayList<Region>(unblockedRegions);
			Collections.sort(sorted, NameUtil.NAMEABLE_COMPARATOR);
			//
			//	Select any unblocked connection that has no outgoing passed regions to unblock all its consumers
			//  before coming back to reconsider which region that actually involves some work is best.
			//
			for (@SuppressWarnings("null")@NonNull Region region : sorted) {
				if (unpassedConnections.contains(region)) {
					return region;
				}
			}
			for (Region region : sorted) {
				if (region instanceof CompositionRegion) {
					return region;		// FIXME this forces joins to the root. Not at root seemsto fail
				}
			}
			//
			//	Select the 'first' region that is not blocked at all.
			//
			return sorted.get(0);
		}
		//
		//	Select any connection subject only to a preferred block and which has no outgoing passed regions.
		//
		for (@SuppressWarnings("null")@NonNull Region region : preferredBlockedRegions) {
			if (unpassedConnections.contains(region)) {
				return region;
			}
		}
		//
		//	Select the 'first' region that is subject to a preferred blockage.
		//
		if (preferredBlockedRegions.size() > 0) {		// FIXME deepest compatible with current context
			List<Region> sorted = new ArrayList<Region>(preferredBlockedRegions);
			Collections.sort(sorted, NameUtil.NAMEABLE_COMPARATOR);
			return sorted.get(0);
		}
		return null;
	}

	/**
	 * Update the callStack so that region is at the top. Update connection2commonRegion so that all
	 * region's incomingConnections are accessible from a commonREgion on the callStack.
	 */
	protected void updateCallStack(@NonNull Region region) {
		Scheduler.REGION_STACK.println(region + " => " + callStack);
		//
		//	Pop stack to commonRegion
		//
		Region topOfStack = callStack.isEmpty() ? null : callStack.peek();
		if (topOfStack != null) {
			Region commonRegion = region2depth.getCommonRegion(topOfStack, region);
			assert commonRegion != null;
			while (!callStack.contains(commonRegion)) {
				commonRegion = region2depth.getMinimumDepthParentRegion(commonRegion);
				assert commonRegion != null;
			}
			while ((topOfStack != commonRegion) && (topOfStack != region)) {
				callStack.pop();
				Region topOfStack2 = callStack.peek();
				assert topOfStack2 != null;
				topOfStack = topOfStack2;
			}
			//
			//	Ensure that connections are hosted by a mutually common region.
			//
			List<Connection> incomingConnections = region2incomingConnections.get(region);
			assert incomingConnections != null;
			for (@SuppressWarnings("null")@NonNull Connection incomingConnection : incomingConnections) {
				if (incomingConnection.isPassed(region)) {
					updateConnectionLocality(incomingConnection, commonRegion);
				}
			}
		}
		//
		//	Push stack to region (without retraversing predecessors)
		//
		if (topOfStack != region) {
			if (topOfStack != null) {
				topOfStack.addCallToChild(region);
			}
			callStack.push(region);
			topOfStack = region;
		}
		assert topOfStack == callStack.peek();
		assert topOfStack == region;
	}

	/**
	 * Update the connection-specific common-region of connection to be a common-region of commonStackRegion
	 * and all source and all target regions of connection.
	 */
	private void updateConnectionLocality(@NonNull Connection connection, @NonNull Region commonStackRegion) {
		assert connection.isPassed();
		Region commonRegion = connection2commonRegion.get(connection);
		if ((commonRegion == null) || ((commonRegion != commonStackRegion) && (region2depth.getCommonRegion(commonRegion, commonStackRegion) != commonRegion))) {
			commonRegion = commonStackRegion;
			List<Region> sourceRegions = connection2sourceRegions.get(connection);
			assert sourceRegions != null;
			for (@SuppressWarnings("null")@NonNull Region sourceRegion : sourceRegions) {
				Region sharedRegion = region2depth.getCommonRegion(commonRegion, sourceRegion);
				assert sharedRegion != null;
				commonRegion = sharedRegion;
			}
			// targetRegion can see commonStackRegion
//			for (@SuppressWarnings("null")@NonNull Region targetRegion : connection2targetRegions.get(connection)) {
//				if (connection.isPassed(targetRegion)) {
//					Region sharedRegion = region2depth.getCommonRegion(commonRegion, targetRegion);
//					assert sharedRegion != null;
//					commonRegion = sharedRegion;
//				}
//			}
			connection2commonRegion.put(connection, commonRegion);
		}
	}
}