/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.DatumConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;

import com.google.common.collect.Iterables;

/**
 * ScheduleCache provides the working state used during the schedule index allocation.
 */
public abstract class ScheduleState extends ScheduleCache
{
	/**
	 * Working state: the regions that have not yet been ordered.
	 */
	private final @NonNull Set<@NonNull Region> blockedRegions = new HashSet<>();

	/**
	 * Working state: the regions that have not yet been ordered but which are blocked by a mandatory access.
	 */
	private final @NonNull Set<@NonNull Region> mandatoryBlockedRegions = new HashSet<>();

	/**
	 * Working state: the regions that have not yet been ordered but whose sources are all fully unblocked.
	 */
	private final @NonNull Set<@NonNull Region> unblockedRegions = new HashSet<>();

	private final @NonNull Map<@NonNull Region, @NonNull Integer> callableRegion2blockedConnectionCount = new HashMap<>();

	/**
	 * Working state: Whether the source has unserviced content for each region's connection source.
	 */
	private final @NonNull Map<@NonNull DatumConnection<?>, @NonNull Map<@NonNull Region, @NonNull Boolean>> connection2sourceRegion2hasContent = new HashMap<>();

	/**
	 * Working state: call stack to access current region.
	 */
	//	private final @NonNull CallTree callTree;

	/**
	 * Working state: the regions that have a schedule index to define their order.
	 */
	private final @NonNull List<@NonNull Region> orderedRegions = new ArrayList<>();

	/**
	 * Working state: connections that block a region.
	 */
	private final @NonNull Set<@NonNull DatumConnection<?>> blockedConnections = new HashSet<>();

	/**
	 * Working state: connections that block a region.
	 */
	private final @NonNull Set<@NonNull ScheduledRegion> blockedScheduledRegions = new HashSet<>();

	protected ScheduleState(@NonNull ScheduledRegion rootScheduledRegion) {
		super(rootScheduledRegion);
		blockedRegions.addAll(callableRegions);
		for (@NonNull Region region : callableRegions) {
			if (region instanceof ScheduledRegion) {
				ScheduledRegion innerScheduledRegion = (ScheduledRegion)region;
				blockedScheduledRegions.add(innerScheduledRegion);
			}
		}
		//
		// Initialize the source/target content of each connection of each region to empty.
		// Compute the set of all connections that are not passed.
		// Compute the set of all regions that are blocked by a mandatory dependence.
		//
		for (@NonNull Region region : this.callableRegions) {
			analyzeInitialConnectionContent(region);
		}
		for (@NonNull Region region : this.callableRegions) {
			//			for (@NonNull DatumConnection connection : region.getIncomingConnections()) {
			Iterable<@NonNull DatumConnection<?>> incomingConnections = getIncomingConnections(region);
			assert incomingConnections != null;
			for (@NonNull DatumConnection<?> connection : incomingConnections) {
				//			if (connection.isOutput()) {
				Map<@NonNull Region, @NonNull Boolean> sourceRegion2hasContent = connection2sourceRegion2hasContent.get(connection);
				assert sourceRegion2hasContent != null;
				/*				if (sourceRegion2hasContent == null) {
					sourceRegion2hasContent = new HashMap<>();
					for (@NonNull Region sourceRegion : connection.getSourceRegions(scheduledRegion)) {
						sourceRegion2hasContent.put(sourceRegion, Boolean.TRUE);
					}
					connection2sourceRegion2hasContent.put(connection, sourceRegion2hasContent);
				} */
				//				Map<@NonNull Region, @NonNull Boolean> targetRegion2hasContent = connection2targetRegion2hasContent.get(connection);
				//				assert targetRegion2hasContent != null;
				/*				if (targetRegion2hasContent == null) {
					targetRegion2hasContent = new HashMap<>();
					for (@NonNull Region targetRegion : connection.getTargetRegions(scheduledRegion)) {
						targetRegion2hasContent.put(targetRegion, Boolean.TRUE);
					}
					connection2targetRegion2hasContent.put(connection, targetRegion2hasContent);
				} */
				//				if (sourceRegion2hasContent.isEmpty()) {		// Source-less connections have their content.
				//					for (@NonNull Region targetRegion : connection.getTargetRegions(scheduledRegion)) {
				//						targetRegion2hasContent.put(targetRegion, Boolean.TRUE);
				//					}
				//				}
			}
		}
		Iterables.addAll(blockedConnections, getConnections());
		for (@NonNull Region region : this.callableRegions) {
			refreshRegionBlockage(region);
		}
		//		callTree = new CallTree(this, rootScheduledRegion);
	}

	/**
	 * Initialize the source/target content of each connection of each region to empty.
	 * Compute the set of all connections that are not passed.
	 * Compute the set of all regions that are blocked by a mandatory dependence.
	 */
	private void analyzeInitialConnectionContent(@NonNull Region region) {
		boolean hasMandatoryUsedConnection = false;
		for (@NonNull DatumConnection<?> connection : getIncomingConnections(region)) {
			if (connection.isMandatory()) {
				hasMandatoryUsedConnection = true;
			}
			Map<@NonNull Region, @NonNull Boolean> sourceRegion2hasContent = connection2sourceRegion2hasContent.get(connection);
			if (sourceRegion2hasContent == null) {
				sourceRegion2hasContent = new HashMap<>();
				for (@NonNull Region sourceRegion : connection.getSourceRegions()) {
					sourceRegion2hasContent.put(sourceRegion, false);
				}
				connection2sourceRegion2hasContent.put(connection, sourceRegion2hasContent);
			}
		}
		if (hasMandatoryUsedConnection) {
			mandatoryBlockedRegions.add(region);
		}
	}

	protected void buildCallTree() {
		CallTreeBuilder callTreeBuilder = new CallTreeBuilder(this);
		callTreeBuilder.buildTree(rootScheduledRegion, orderedRegions);
	}

	protected @NonNull Iterable<@NonNull Region> getBlockedCallableRegions() {
		return callableRegion2blockedConnectionCount.keySet();
	}

	protected @Nullable Integer getBlockedConnectionCount(@NonNull Region region) {
		return callableRegion2blockedConnectionCount.get(region);
	}

	protected @NonNull Iterable<? extends @NonNull DatumConnection<?>> getBlockedConnections() {
		return blockedConnections;
	}

	protected @NonNull Iterable<? extends @NonNull Region> getMandatoryBlockedRegions() {
		return mandatoryBlockedRegions;
	}

	public @NonNull List<@NonNull Region> getOrdering() {
		return orderedRegions;
	}

	private @NonNull Map<@NonNull Region, @NonNull Boolean> getSourceRegion2hasContent(@NonNull DatumConnection<?> connection) {
		Map<@NonNull Region, @NonNull Boolean> sourceRegion2hasContent = connection2sourceRegion2hasContent.get(connection);
		assert sourceRegion2hasContent != null;
		return sourceRegion2hasContent;
	}

	protected @NonNull Iterable<? extends @NonNull Region> getUnblockedRegions() {
		return unblockedRegions;
	}

	private boolean isBlocked(@NonNull DatumConnection<?> connection) {
		return blockedConnections.contains(connection);
	}

	private void propagateIndexes(@NonNull DatumConnection<?> connection) {
		List<@NonNull Integer> connectionIndexes = connection.getIndexes();
		if (connectionIndexes.size() > 0) {			// Empty for dead inputs
			for (@NonNull Region region : getTargetRegions(connection)) {
				int invocationIndex = region.getInvocationIndex();
				boolean propagateThroughRegion = false;
				for (int connectionIndex : connectionIndexes) {
					if ((connectionIndex > invocationIndex) && region.addIndex(connectionIndex)) {
						propagateThroughRegion = true;
					}
				}
				if (propagateThroughRegion) {
					Iterable<@NonNull DatumConnection<?>> outgoingConnections = getOutgoingConnections(region);
					for (@NonNull DatumConnection<?> targetConnection : outgoingConnections) {
						boolean propagateThroughConnection = false;
						for (int connectionIndex : connectionIndexes) {
							if (targetConnection.addIndex(connectionIndex)) {
								propagateThroughConnection = true;
							}
						}
						if (propagateThroughConnection) {
							propagateIndexes(targetConnection);
						}
					}
				}
			}
		}
	}

	/**
	 * Update the state of connection following the scheduling of region.
	 * Add any regions whose blockage should be reconsidered to nextRegions.
	 */
	private void refreshConnectionBlockage(@NonNull DatumConnection<?> connection,
			@NonNull Region region, @NonNull Set<@NonNull Region> nextRegions) {
		//
		//	Update the relevant source region state.
		//
		Map<@NonNull Region, @NonNull Boolean> sourceRegion2hasContent = getSourceRegion2hasContent(connection);
		sourceRegion2hasContent.put(region, Boolean.TRUE);
		//
		//	Nothing to do if some source region has no content yet.
		//
		for (@NonNull Boolean hasContent : sourceRegion2hasContent.values()) {
			if (!hasContent) {
				return;
			}
		}
		//
		//	Unblock the connection.
		//
		blockedConnections.remove(connection);
		//
		//	Unblock the scheduled regions of any connection target regions.
		//
		/*		if (connection.isPassed()) {
			for (@NonNull Region targetRegion : getTargetRegions(connection)) {
				for (Region invokingRegion = targetRegion.getInvokingRegion(); invokingRegion != null; invokingRegion = invokingRegion.getInvokingRegion()) {
					if (blockedScheduledRegions.contains(invokingRegion)) {
						boolean isBlocked = false;
						ScheduledRegion scheduledRegion = (ScheduledRegion)invokingRegion;
						for (@NonNull Connection scheduledConnection : scheduledRegion.getIncomingPassedConnections()) {
							if (blockedConnections.contains(scheduledConnection)) {
								isBlocked = true;
								break;
							}
						}
						if (!isBlocked) {
							blockedScheduledRegions.remove(scheduledRegion);
							unblockedRegions.add(scheduledRegion);
							nextRegions.add(scheduledRegion);
						}
					}
				}
			}
		} */
		//
		//	Mark all targets for reconsideration.
		//
		for (@NonNull Region nextRegion : getTargetRegions(connection)) {
			if (nextRegion != region) {
				nextRegions.add(nextRegion);
			}
		}
	}

	/**
	 * Update the state of region following the unblocking of one of its incoming connections,
	 * returning true if unblocked.
	 */
	private boolean refreshRegionBlockage(@NonNull Region region) {
		ScheduledRegion invokingRegion = RegionUtil.getOwningScheduledRegion(region);
		if (blockedRegions.contains(invokingRegion) && !unblockedRegions.contains(invokingRegion)) {
			if (!refreshRegionBlockage(invokingRegion)) {
				return false;
			}
		}
		if (region instanceof ScheduledRegion) {
			boolean isBlocked = false;
			ScheduledRegion scheduledRegion = (ScheduledRegion)region;
			for (@NonNull Connection connection : scheduledRegion.getIncomingPassedConnections()) {
				if (blockedConnections.contains(connection)) {
					isBlocked = true;
					break;
				}
			}
			if (!isBlocked) {
				assert !orderedRegions.contains(scheduledRegion);
				blockedScheduledRegions.remove(scheduledRegion);
				unblockedRegions.add(scheduledRegion);
				callableRegion2blockedConnectionCount.remove(region);
				return true;
			}
			return false;
		}
		boolean hasPassedBlock = false;
		boolean hasMandatoryBlock = false;
		Iterable<@NonNull DatumConnection<?>> incomingConnections = getIncomingConnections(region);
		assert incomingConnections != null;
		int blockedConnectionCount = 0;
		for (@NonNull DatumConnection<?> connection : incomingConnections) {
			if (isBlocked(connection)) {
				blockedConnectionCount++;
				if (connection.isPassed()) {
					hasPassedBlock = true;
					//					assert callableRegion2blockedConnectionCount.containsKey(region);
				}
				else if (connection.isMandatory()) {
					hasMandatoryBlock = true;
					//					assert mandatoryBlockedRegions.contains(region);
				}
			}
		}
		if (hasMandatoryBlock) {
			assert mandatoryBlockedRegions.contains(region);
			assert !unblockedRegions.contains(region);
			assert !callableRegion2blockedConnectionCount.containsKey(region);
		}
		else {
			mandatoryBlockedRegions.remove(region);
			if (hasPassedBlock) {
				assert !unblockedRegions.contains(region);
				assert !callableRegion2blockedConnectionCount.containsKey(region);
			}
			else if (blockedConnectionCount > 0) {
				assert !orderedRegions.contains(region);
				assert !unblockedRegions.contains(region);
				callableRegion2blockedConnectionCount.put(region, blockedConnectionCount);
			}
			else if (blockedRegions.contains(invokingRegion)) {
				assert !orderedRegions.contains(region);
				assert !unblockedRegions.contains(region);
				callableRegion2blockedConnectionCount.put(region, blockedConnectionCount);
			}
			else if (!orderedRegions.contains(region)) {
				unblockedRegions.add(region);
				callableRegion2blockedConnectionCount.remove(region);
				return true;
			}
			else {
				assert !unblockedRegions.contains(region);
			}
		}
		return false;
	}

	protected void scheduleRegion(@NonNull Region region) {
		int thisIndex = orderedRegions.size();
		QVTm2QVTs.REGION_ORDER.println(thisIndex + " : " + region);
		assert !orderedRegions.contains(region) : "Attempting to re-order " + region;
		region.addIndex(thisIndex);
		orderedRegions.add(region);
		unblock(region);
		//
		//	Drain incomingConnections wrt selectedRegion
		//
		//		List<@NonNull DatumConnection> incomingConnections = getIncomingConnections(selectedRegion);
		//		assert incomingConnections != null;
		Iterable<@NonNull DatumConnection<?>> loopingConnections = getLoopingConnections(region);
		assert loopingConnections != null;
		Iterable<@NonNull DatumConnection<?>> outgoingConnections = getOutgoingConnections(region);
		assert outgoingConnections != null;
		//		for (@NonNull DatumConnection incomingConnection : incomingConnections) {
		//			List<@NonNull Region> targetRegions = getTargetRegions(incomingConnection);
		//			assert targetRegions != null;
		//			Boolean oldHasContent = targetRegion2hasContent.put(selectedRegion, Boolean.FALSE);
		//			assert oldHasContent != null;
		//		}
		//	Ignore loopingConnections, necessarily incomplete on entry, complete on recursion exit
		//		for (Connection loopingConnection : loopingConnections) {
		//			Map<@NonNull Region, @NonNull Boolean> targetRegion2hasContent = connection2targetRegion2hasContent.get(loopingConnection);
		//			Boolean oldHasContent = targetRegion2hasContent.put(selectedRegion, Boolean.FALSE);
		//			assert oldHasContent != null;
		//		}
		//		if (childClass.conformsTo(parentClass)) {
		//		Edges.PRIMARY_RECURSION.createEdge(containmentRegion, introducedNode, headNode);
		//	}
		//
		//	Fill outgoingConnections wrt selectedRegion
		//
		Set<@NonNull Region> nextRegions = new HashSet<>();
		for (@NonNull DatumConnection<?> loopingConnection : loopingConnections) {
			loopingConnection.addIndex(thisIndex);
			//			refreshConnectionBlockage(outgoingConnection, selectedRegion, nextRegions);
		}
		for (@NonNull DatumConnection<?> outgoingConnection : outgoingConnections) {
			outgoingConnection.addIndex(thisIndex);
			refreshConnectionBlockage(outgoingConnection, region, nextRegions);
		}
		//
		//	Unblock connections whose final blocking source is the selectedRegion.
		//
		//		assert !alreadyIndexed;
		//		assert loopingConnections != null;
		//		assert outgoingConnections != null;
		/*			List<@NonNull Connection> connections = new ArrayList<>();
		connections.addAll(loopingConnections);
		connections.addAll(outgoingConnections);
		Collections.sort(connections, NameUtil.NAMEABLE_COMPARATOR);
		for (Connection outgoingConnection : connections) {
			if (refreshConnectionBlockage(outgoingConnection)) {
				if (!orderedSchedulables.contains(outgoingConnection)) {			// re-unblocking can occur when multiple regions are unblocked at once
//					int size = orderedSchedulables.size();
					Scheduler.REGION_ORDER.println(/*size +* / "-- : " + outgoingConnection);
//					outgoingConnection.addIndex(size);
//					orderedSchedulables.add(outgoingConnection);
					Map<@NonNull Region, @NonNull Boolean> targetRegion2hasContent = connection2targetRegion2hasContent.get(outgoingConnection);
					if (targetRegion2hasContent != null) {
						nextRegions.addAll(targetRegion2hasContent.keySet());
					}
				}
			}
		} */
		//
		//	Unblock regions whose source connections were unblocked.
		//
		for (@NonNull Region nextRegion : nextRegions) {
			if (!orderedRegions.contains(nextRegion)) {
				refreshRegionBlockage(nextRegion);
			}
		}
		//		callTree.updateCallStack(region);
		if (region instanceof ScheduledRegion) {
			ScheduledRegion scheduledRegion = (ScheduledRegion)region;
			scheduleScheduledRegion(scheduledRegion);
		}
	}

	public void schedule(@NonNull ScheduledRegion rootScheduledRegion) {
		scheduleScheduledRegion(rootScheduledRegion);
		/**
		 * Propagate the additional connection indexes to their outgoing connections.
		 */
		for (@NonNull DatumConnection<?> connection : getConnections()) {
			propagateIndexes(connection);
		}
		buildCallTree();
	}

	protected abstract void scheduleScheduledRegion(@NonNull ScheduledRegion scheduledRegion);

	private void unblock(@NonNull Region region) {
		assert !blockedRegions.contains(RegionUtil.getOwningScheduledRegion(region));
		boolean wasRemoved0 = blockedRegions.remove(region);
		assert wasRemoved0;
		boolean wasRemoved1 = unblockedRegions.remove(region);
		boolean wasRemoved2 = callableRegion2blockedConnectionCount.remove(region) != null;
		boolean wasRemoved3 = true;//partiallyBlockedRegions2availableFraction.remove(selectedRegion) != null;
		assert wasRemoved1 || wasRemoved2 || wasRemoved3;
	}
}