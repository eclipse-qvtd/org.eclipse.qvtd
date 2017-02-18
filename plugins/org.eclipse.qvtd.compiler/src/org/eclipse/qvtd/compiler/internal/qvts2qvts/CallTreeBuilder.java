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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtschedule.DatumConnection;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;

import com.google.common.collect.Iterables;

/**
 * CallTreeBuilder simulates execution of the indexed regions resulting in a call tree that ensures that each regions
 * is executed after its predecessors, nested to re-use as much prior context from the call stack.
 */
public class CallTreeBuilder
{
	private final @NonNull ScheduleCache scheduleCache;

	/**
	 * Working state: the common region for all uses of each connection.
	 */
	private final @NonNull Map<@NonNull NodeConnection, @NonNull Region> connection2commonRegion = new HashMap<@NonNull NodeConnection, @NonNull Region>();

	public CallTreeBuilder(@NonNull ScheduleCache scheduleCache) {
		this.scheduleCache = scheduleCache;
	}

	public void buildTree(@NonNull ScheduledRegion rootScheduledRegion, @NonNull List<@NonNull Region> orderedRegions) {
		Stack<@NonNull Region> callStack = new Stack<@NonNull Region>();
		callStack.push(rootScheduledRegion);
		for (@NonNull Region region: orderedRegions) {
			updateCallStack(callStack, region);
		}
		installConnections();
	}

	protected @NonNull Region getCommonRegion(@NonNull Region firstRegion, @NonNull Region secondRegion) {
		Region commonRegion = scheduleCache.getCommonRegion(firstRegion, secondRegion);
		assert commonRegion != null;
		return commonRegion;
	}

	protected @NonNull Region getMinimumDepthParentRegion(@NonNull Region childRegion) {
		Region minimumDepthParentRegion = scheduleCache.getMinimumDepthParentRegion(childRegion);
		assert minimumDepthParentRegion != null;
		return minimumDepthParentRegion;
	}

	/**
	 * Install all connections so that the connection variable is declared at the common region and passed through all the
	 * intermediate regions between the common region and the regions that use the connection variable as a source or target.
	 */
	protected void installConnections() {
		List<@NonNull NodeConnection> connections = new ArrayList<>(connection2commonRegion.keySet());
		Collections.sort(connections, new Comparator<@NonNull NodeConnection>()		// impriive determinism
			{
			@Override
			public int compare(@NonNull NodeConnection o1, @NonNull NodeConnection o2) {
				List<@NonNull Integer> l1 = o1.getIndexes();
				List<@NonNull Integer> l2 = o2.getIndexes();
				int x1 = l1.size() > 0 ? l1.get(0) : -1;
				int x2 = l2.size() > 0 ? l2.get(0) : -1;
				return x1-x2;
			}
			});
		for (@NonNull NodeConnection connection : connections) {
			if (connection.isPassed()) {
				Region commonRegion = connection2commonRegion.get(connection);
				assert commonRegion != null;
				List<@NonNull Region> intermediateRegions = new ArrayList<@NonNull Region>();
				//				boolean isCyclic = scheduledRegion.isCyclicScheduledRegion();
				//				if (isCyclic) {		// FIXME should not be necessary
				//					intermediateRegions.add(scheduledRegion);
				//				}
				for (@NonNull Region sourceRegion : scheduleCache.getSourceRegions(connection)) {
					if (sourceRegion != commonRegion) { //|| sourceRegion.isCyclicScheduledRegion()) {
						Iterable<@NonNull Region> sourceRegions = Collections.singletonList(sourceRegion);
						installConnectionsLocateIntermediates(intermediateRegions, sourceRegions, commonRegion);
					}
				}
				for (@NonNull Region targetRegion : scheduleCache.getTargetRegions(connection)) {
					if ((targetRegion != commonRegion) && connection.isPassed(targetRegion)) {
						Iterable<@NonNull Region> targetRegions2 = /*targetRegion.isCyclicScheduledRegion() ? Collections.singletonList(targetRegion) :*/ targetRegion.getCallableParents();
						installConnectionsLocateIntermediates(intermediateRegions, targetRegions2, commonRegion);
					}
				}
				connection.setCommonRegion(commonRegion, intermediateRegions);
				//				Scheduler.REGION_LOCALITY.println(connection + " => " + commonRegion + " " + intermediateRegions);
			}
		}
		for (@NonNull NodeConnection connection : connections) {
			if (connection.isPassed()) {
				Region commonRegion = connection.getCommonRegion();
				assert commonRegion != null;
				List<@NonNull Region> intermediateRegions = connection.getIntermediateRegions();
				for (@NonNull Region intermediateRegion : intermediateRegions) {
					Region checkCommonRegion = commonRegion.getLoopingConnections().size() > 0 ? RegionUtil.getOwningScheduledRegion(commonRegion) : commonRegion;
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
	protected void installConnectionsLocateIntermediates(@NonNull List<@NonNull Region> intermediateRegions, @NonNull Iterable<@NonNull Region> callableParents, @NonNull Region commonRegion) {
		for (@NonNull Region callableParent : callableParents) {
			if (callableParent != commonRegion) {
				if (!intermediateRegions.contains(callableParent)) {
					intermediateRegions.add(callableParent);
					installConnectionsLocateIntermediates(intermediateRegions, callableParent.getCallableParents(), commonRegion);
				}
			}
		}
	}

	/**
	 * Update the callStack so that region is at the top. Update connection2commonRegion so that all
	 * region's incomingConnections are accessible from a commonRegion on the callStack.
	 */
	protected void updateCallStack(@NonNull Stack<@NonNull Region> callStack, @NonNull Region region) {
		QVTm2QVTs.REGION_STACK.println(region.getSymbolName() + " => " + callStack);
		//
		//	Pop stack to commonRegion
		//
		Region topOfStack = callStack.peek();
		assert topOfStack != null;
		@NonNull Region commonRegion = getCommonRegion(topOfStack, region);
		//
		//	Must identify the call point at which all source values are available.
		//
		//	The 'easy' safe inefficient case is the caller of the common region of all sources.
		//
		//	FIXME: The optimized case for a single-headed region ensures that for all candidate sources for the head,
		//	the to-one region from the head's source covers all the required producer-consumer dependencies.
		//
		//	Obsolete special case: If the caller is a recursion, ensure the the caller's caller is on the stack.
		//
		/*		for (@NonNull DatumConnection incomingConnection1 : scheduleCache.getIncomingConnections(region)) {		// FIXME passed
			for (@NonNull Region sourceRegion1 : scheduleCache.getSourceRegions(incomingConnection1)) {
				if (sourceRegion1.getLoopingConnections().size() > 0) {
					for (@NonNull DatumConnection incomingConnection2 : scheduleCache.getIncomingConnections(sourceRegion1)) {		// FIXME passed
						for (@NonNull Region sourceRegion2 : scheduleCache.getSourceRegions(incomingConnection2)) {
							commonRegion = getCommonRegion(commonRegion, sourceRegion2);
						}
					}
				}
			}
		} */
		for (@NonNull DatumConnection<?> incomingConnection1 : scheduleCache.getIncomingConnections(region)) {
			for (@NonNull Region sourceRegion1 : scheduleCache.getSourceRegions(incomingConnection1)) {
				//				if (sourceRegion1.getLoopingConnections().size() > 0) {
				for (@NonNull DatumConnection<?> incomingConnection2 : scheduleCache.getIncomingConnections(sourceRegion1)) {
					for (@NonNull Region sourceRegion2 : scheduleCache.getSourceRegions(incomingConnection2)) {
						commonRegion = getCommonRegion(commonRegion, sourceRegion2);
					}
				}
				//				}
			}
		}
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
		for (@NonNull DatumConnection<?> incomingConnection : scheduleCache.getIncomingConnections(region)) {
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
	protected @NonNull Region updateConnectionLocality(@NonNull NodeConnection connection, @NonNull Region commonStackRegion) {
		assert connection.isPassed();
		Region oldCommonRegion = connection2commonRegion.get(connection);
		@NonNull Region commonRegion;
		if (oldCommonRegion == null) {
			commonRegion = commonStackRegion;
			for (@NonNull Region sourceRegion : scheduleCache.getSourceRegions(connection)) {
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