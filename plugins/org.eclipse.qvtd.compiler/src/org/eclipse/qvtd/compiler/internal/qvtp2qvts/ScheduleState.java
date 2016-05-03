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
import java.util.Stack;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import com.google.common.collect.Iterables;

/**
 * ScheduleCache provides the working state used during the schedule index allocation.
 */
public abstract class ScheduleState extends ScheduleCache
{
	/**
	 * Working state: the regions that have not yet been ordered.
	 */
	private final @NonNull Set<@NonNull Region> blockedRegions = new HashSet<@NonNull Region>();
	
	/**
	 * Working state: the regions that have not yet been ordered but which are blocked by a mandatory access.
	 */
	private final @NonNull Set<@NonNull Region> mandatoryBlockedRegions = new HashSet<@NonNull Region>();
	
	/**
	 * Working state: the regions that have not yet been ordered but whose sources are all fully unblocked.
	 */
	private final @NonNull Set<@NonNull Region> unblockedRegions = new HashSet<@NonNull Region>();

	private final @NonNull Map<@NonNull Region, @NonNull Integer> callableRegion2blockedConnectionCount = new HashMap<@NonNull Region, @NonNull Integer>();

	/**
	 * Working state: Whether the source has unserviced content for each region's connection source.
	 */
	private final @NonNull Map<@NonNull DatumConnection, @NonNull Map<@NonNull Region, @NonNull Boolean>> connection2sourceRegion2hasContent = new HashMap<@NonNull DatumConnection, @NonNull Map<@NonNull Region, @NonNull Boolean>>();
	
	/**
	 * Working state: the common region for all uses of each connection.
	 */
	private final @NonNull Map<@NonNull NodeConnection, @NonNull Region> connection2commonRegion = new HashMap<@NonNull NodeConnection, @NonNull Region>();

	/**
	 * Working state: call stack to access current region.
	 */
	private final @NonNull Stack<@NonNull Region> callStack = new Stack<@NonNull Region>();
	
	/**
	 * Working state: the regions that have a schedule index to define their order.
	 */
	private final @NonNull List<@NonNull Region> orderedRegions = new ArrayList<@NonNull Region>();

	/**
	 * Working state: connections that block a region.
	 */
	private final @NonNull Set<@NonNull Connection> blockedConnections = new HashSet<@NonNull Connection>();

	/**
	 * Working state: connections that block a region.
	 */
	private final @NonNull Set<@NonNull ScheduledRegion> blockedScheduledRegions = new HashSet<@NonNull ScheduledRegion>();

	protected ScheduleState(@NonNull RootScheduledRegion rootScheduledRegion) {
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
			Iterable<@NonNull DatumConnection> incomingConnections = getIncomingConnections(region);
			assert incomingConnections != null;
			for (@NonNull DatumConnection connection : incomingConnections) {
//			if (connection.isOutput()) {
				Map<@NonNull Region, @NonNull Boolean> sourceRegion2hasContent = connection2sourceRegion2hasContent.get(connection);
				assert sourceRegion2hasContent != null;
/*				if (sourceRegion2hasContent == null) {
					sourceRegion2hasContent = new HashMap<@NonNull Region, @NonNull Boolean>();
					for (@NonNull Region sourceRegion : connection.getSourceRegions(scheduledRegion)) {
						sourceRegion2hasContent.put(sourceRegion, Boolean.TRUE);
					}
					connection2sourceRegion2hasContent.put(connection, sourceRegion2hasContent);
				} */
//				Map<@NonNull Region, @NonNull Boolean> targetRegion2hasContent = connection2targetRegion2hasContent.get(connection);
//				assert targetRegion2hasContent != null;
/*				if (targetRegion2hasContent == null) {
					targetRegion2hasContent = new HashMap<@NonNull Region, @NonNull Boolean>();
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
		callStack.push(rootScheduledRegion);
	}

	/**
	 * Initialize the source/target content of each connection of each region to empty.
	 * Compute the set of all connections that are not passed. 
	 * Compute the set of all regions that are blocked by a mandatory dependence. 
	 */
	private void analyzeInitialConnectionContent(@NonNull Region region) {
		boolean hasMandatoryUsedConnection = false;
		for (@NonNull DatumConnection connection : getIncomingConnections(region)) {
			if (connection.isMandatory()) {
				hasMandatoryUsedConnection = true;
			}
			Map<@NonNull Region, @NonNull Boolean> sourceRegion2hasContent = connection2sourceRegion2hasContent.get(connection);
			if (sourceRegion2hasContent == null) {
				sourceRegion2hasContent = new HashMap<@NonNull Region, @NonNull Boolean>();
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

	protected @NonNull Iterable<@NonNull Region> getBlockedCallableRegions() {
		return callableRegion2blockedConnectionCount.keySet();
	}

	protected @Nullable Integer getBlockedConnectionCount(@NonNull Region region) {
		return callableRegion2blockedConnectionCount.get(region);
	}

	protected @NonNull Iterable<? extends @NonNull Connection> getBlockedConnections() {
		return blockedConnections;
	}

	@Override
	public @NonNull Region getCommonRegion(@NonNull Region firstRegion, @NonNull Region secondRegion) {
		Region commonRegion = super.getCommonRegion(firstRegion, secondRegion);
		assert commonRegion != null;
		return commonRegion;
	}

	protected @NonNull Iterable<? extends @NonNull Region> getMandatoryBlockedRegions() {
		return mandatoryBlockedRegions;
	}

	@Override
	public @NonNull Region getMinimumDepthParentRegion(@NonNull Region childRegion) {
		Region minimumDepthParentRegion = super.getMinimumDepthParentRegion(childRegion);
		assert minimumDepthParentRegion != null;
		return minimumDepthParentRegion;
	}

	public @NonNull List<@NonNull Region> getOrdering() {
		return orderedRegions;
	}

	private @NonNull Map<@NonNull Region, @NonNull Boolean> getSourceRegion2hasContent(@NonNull DatumConnection connection) {
		Map<@NonNull Region, @NonNull Boolean> sourceRegion2hasContent = connection2sourceRegion2hasContent.get(connection);
		assert sourceRegion2hasContent != null;
		return sourceRegion2hasContent;
	}

	protected @NonNull Iterable<? extends @NonNull Region> getUnblockedRegions() {
		return unblockedRegions;
	}

	/**
	 * Install all connections so that the connection variable is declared at the common region and passed through all the
	 * intermediate regions between the common region and the regions that use the connection variable as a source or target.
	 */
	protected void installConnections() {
		for (@NonNull NodeConnection connection : connection2commonRegion.keySet()) {
			if (connection.isPassed()) {
				Region commonRegion = connection2commonRegion.get(connection);
				assert commonRegion != null;
				List<@NonNull Region> intermediateRegions = new ArrayList<@NonNull Region>();
//				boolean isCyclic = scheduledRegion.isCyclicScheduledRegion();
//				if (isCyclic) {		// FIXME should not be necessary
//					intermediateRegions.add(scheduledRegion);
//				}
				for (@NonNull Region sourceRegion : getSourceRegions(connection)) {
					if (sourceRegion != commonRegion) { //|| sourceRegion.isCyclicScheduledRegion()) {
						Iterable<@NonNull Region> sourceRegions = Collections.singletonList(sourceRegion);
						installConnectionsLocateIntermediates(intermediateRegions, sourceRegions, commonRegion);
					}
				}
				for (@NonNull Region targetRegion : getTargetRegions(connection)) {
					if ((targetRegion != commonRegion) && connection.isPassed(targetRegion)) {
						Iterable<@NonNull Region> targetRegions2 = /*targetRegion.isCyclicScheduledRegion() ? Collections.singletonList(targetRegion) :*/ targetRegion.getCallableParents();
						installConnectionsLocateIntermediates(intermediateRegions, targetRegions2, commonRegion);
					}
				}
				connection.setCommonRegion(commonRegion, intermediateRegions);
//				Scheduler.REGION_LOCALITY.println(connection + " => " + commonRegion + " " + intermediateRegions);
			}
		}
		for (@NonNull NodeConnection connection : connection2commonRegion.keySet()) {
			if (connection.isPassed()) {
				Region commonRegion = connection.getCommonRegion();
				assert commonRegion != null;
				List<@NonNull Region> intermediateRegions = connection.getIntermediateRegions();
				for (@NonNull Region intermediateRegion : intermediateRegions) {
					Region checkCommonRegion = commonRegion.getLoopingConnections().size() > 0 ? commonRegion.getInvokingRegion() : commonRegion;
					assert commonRegion.getLoopingConnections().size() > 0
						? Iterables.contains(commonRegion.getCallableParents(), getCommonRegion(commonRegion, intermediateRegion))
						: getCommonRegion(commonRegion, intermediateRegion) == checkCommonRegion;
				}
			}
		}
	}

	/**
	 * Recursively locate all the regions that are traversed as a call sub-tree rooted at commonRegion invokes each of callableParents.
	 */
	private void installConnectionsLocateIntermediates(@NonNull List<@NonNull Region> intermediateRegions, @NonNull Iterable<@NonNull Region> callableParents, @NonNull Region commonRegion) {
		for (@NonNull Region callableParent : callableParents) {
			if (callableParent != commonRegion) {
				if (!intermediateRegions.contains(callableParent)) {
					intermediateRegions.add(callableParent);
					installConnectionsLocateIntermediates(intermediateRegions, callableParent.getCallableParents(), commonRegion);
				}
			}
		}
	}

	private boolean isBlocked(@NonNull DatumConnection connection) {
		return blockedConnections.contains(connection);
	}

	private void propagateIndexes(@NonNull DatumConnection connection) {
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
					Iterable<@NonNull DatumConnection> outgoingConnections = getOutgoingConnections(region);
					for (@NonNull DatumConnection targetConnection : outgoingConnections) {
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
	private void refreshConnectionBlockage(@NonNull DatumConnection connection,
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
		ScheduledRegion invokingRegion = region.getInvokingRegion();
		assert invokingRegion != null;
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
		Iterable<@NonNull DatumConnection> incomingConnections = getIncomingConnections(region);
		assert incomingConnections != null;
		int blockedConnectionCount = 0;
		for (@NonNull DatumConnection connection : incomingConnections) {
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
		Scheduler.REGION_ORDER.println(thisIndex + " : " + region);
		assert !orderedRegions.contains(region) : "Attempting to re-order " + region;
		region.addIndex(thisIndex);
		orderedRegions.add(region);
		unblock(region);
		//
		//	Drain incomingConnections wrt selectedRegion
		//
//		List<@NonNull DatumConnection> incomingConnections = getIncomingConnections(selectedRegion);
//		assert incomingConnections != null;
		Iterable<@NonNull DatumConnection> loopingConnections = getLoopingConnections(region);
		assert loopingConnections != null;
		Iterable<@NonNull DatumConnection> outgoingConnections = getOutgoingConnections(region);
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
		Set<@NonNull Region> nextRegions = new HashSet<@NonNull Region>();
		for (@NonNull DatumConnection loopingConnection : loopingConnections) {
			loopingConnection.addIndex(thisIndex);
//			refreshConnectionBlockage(outgoingConnection, selectedRegion, nextRegions);
		}
		for (@NonNull DatumConnection outgoingConnection : outgoingConnections) {
			outgoingConnection.addIndex(thisIndex);
			refreshConnectionBlockage(outgoingConnection, region, nextRegions);
		}
		//
		//	Unblock connections whose final blocking source is the selectedRegion.
		//
//		assert !alreadyIndexed;
//		assert loopingConnections != null;
//		assert outgoingConnections != null;
/*			List<@NonNull Connection> connections = new ArrayList<@NonNull Connection>();
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
		updateCallStack(region);
		if (region instanceof ScheduledRegion) {
			ScheduledRegion scheduledRegion = (ScheduledRegion)region;
			scheduleScheduledRegion(scheduledRegion);
		}
	}

	public void schedule(@NonNull RootScheduledRegion rootScheduledRegion) {
		scheduleScheduledRegion(rootScheduledRegion);
		/**
		 * Propagate the additional connection indexes to their outgoing connections.
		 */
		for (@NonNull DatumConnection connection : getConnections()) {
			propagateIndexes(connection);
		}
		installConnections();
	}
	
	protected abstract void scheduleScheduledRegion(@NonNull ScheduledRegion scheduledRegion);

	private void unblock(@NonNull Region region) {
		assert !blockedRegions.contains(region.getInvokingRegion());
		boolean wasRemoved0 = blockedRegions.remove(region);
		assert wasRemoved0;
		boolean wasRemoved1 = unblockedRegions.remove(region);
		boolean wasRemoved2 = callableRegion2blockedConnectionCount.remove(region) != null;
//		boolean wasRemoved3 = partiallyBlockedRegions2availableFraction.remove(selectedRegion) != null;
		assert wasRemoved1 || wasRemoved2;// || wasRemoved3;
	}

	/**
	 * Update the callStack so that region is at the top. Update connection2commonRegion so that all
	 * region's incomingConnections are accessible from a commonRegion on the callStack.
	 */
	private void updateCallStack(@NonNull Region region) {
		Scheduler.REGION_STACK.println(region.getSymbolName() + " => " + callStack);
		//
		//	Pop stack to commonRegion
		//
		Region topOfStack = callStack.peek();
		assert topOfStack != null;
		@NonNull Region commonRegion = getCommonRegion(topOfStack, region);
		//
		//	If the caller is a recursion, ensure the the caller's caller is on the stack.
		//
/*		for (@NonNull DatumConnection incomingConnection1 : getIncomingConnections(region)) {		// FIXME passed
			for (@NonNull Region sourceRegion1 : getSourceRegions(incomingConnection1)) {
				if (sourceRegion1.getLoopingConnections().size() > 0) {
					for (@NonNull DatumConnection incomingConnection2 : getIncomingConnections(sourceRegion1)) {		// FIXME passed
						for (@NonNull Region sourceRegion2 : getSourceRegions(incomingConnection2)) {
							commonRegion = getCommonRegion(commonRegion, sourceRegion2);
						}
					}
				}
			}
		} */
		while (!callStack.contains(commonRegion)) {
			commonRegion = getMinimumDepthParentRegion(commonRegion);
			assert commonRegion != null;
		}
		while ((topOfStack != commonRegion) && (topOfStack != region)) {
			callStack.pop();
			Region topOfStack2 = callStack.peek();
			assert topOfStack2 != null;
			topOfStack = topOfStack2;
		}
		//
		//	Ensure that passed connections are hosted by a mutually common region.
		//
//		Iterable<@NonNull DatumConnection> incomingConnections = getIncomingConnections(region);
//		assert incomingConnections != null;
		for (@NonNull DatumConnection incomingConnection : getIncomingConnections(region)) {
			if (incomingConnection.isPassed(region)) {
				commonRegion = updateConnectionLocality((@NonNull NodeConnection) incomingConnection, commonRegion);
			}
		}
//		Iterable<@NonNull DatumConnection> outgoingConnections = getOutgoingConnections(region);
//		assert outgoingConnections != null;
//		for (@NonNull DatumConnection outgoingConnection : outgoingConnections) {
//			if (outgoingConnection.isOutput()) {
//				commonRegion = updateConnectionLocality((@NonNull NodeConnection) outgoingConnection, commonRegion);
//			}
//		}
		//
		//	Push stack to region (without re-traversing predecessors)
		//
		if (topOfStack != region) {
			topOfStack.addCallToChild(region);
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
	private @NonNull Region updateConnectionLocality(@NonNull NodeConnection connection, @NonNull Region commonStackRegion) {
		assert connection.isPassed();
		Region oldCommonRegion = connection2commonRegion.get(connection);
		@NonNull Region commonRegion;
		if (oldCommonRegion == null) {
			commonRegion = commonStackRegion;
			for (@NonNull Region sourceRegion : getSourceRegions(connection)) {
				commonRegion = getCommonRegion(commonRegion, sourceRegion);
			}
		}
		else {
			commonRegion = getCommonRegion(oldCommonRegion, commonStackRegion);
		}
		if (oldCommonRegion != commonRegion) {
			connection2commonRegion.put(connection, commonRegion);
		}
		return commonRegion;
	}
}