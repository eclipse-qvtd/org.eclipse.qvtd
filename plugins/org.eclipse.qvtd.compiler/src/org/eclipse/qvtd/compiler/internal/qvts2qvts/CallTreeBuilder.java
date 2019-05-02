/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
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
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionsAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.RootPartition;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

/**
 * CallTreeBuilder simulates execution of the indexed regions resulting in a call tree that ensures that each regions
 * is executed after its predecessors, nested to re-use as much prior context from the call stack.
 */
public class CallTreeBuilder
{
	private final @NonNull ScheduleAnalysis scheduleCache;
	private final @NonNull ConnectionManager connectionManager;
	private final @NonNull RootPartition rootPartition;
	private final @NonNull LoadingPartition loadingPartition;

	/**
	 * Working state: the common region for all uses of each connection.
	 */
	private final @NonNull Map<@NonNull NodeConnection, @NonNull Partition> connection2commonPartition = new HashMap<>();

	public CallTreeBuilder(@NonNull ScheduleAnalysis scheduleCache, @NonNull RootPartition rootPartition, @NonNull LoadingPartition loadingPartition) {
		this.scheduleCache = scheduleCache;
		this.connectionManager = scheduleCache.getConnectionManager();
		this.rootPartition = rootPartition;
		this.loadingPartition = loadingPartition;
	}

	public void buildTree(@NonNull Iterable<@NonNull Concurrency> partitionSchedule) {
		Stack<@NonNull Partition> callStack = new Stack<>();
		callStack.push(rootPartition);
		for (@NonNull Concurrency concurrency : partitionSchedule) {
			for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partition : concurrency) {
				updateCallStack(callStack, partition.getPartition());
			}
		}
		installConnections();
	}

	protected @NonNull Partition getCommonPartition(@NonNull Partition firstPartition, @NonNull Partition secondPartition) {
		//		Partition commonPartition = scheduleCache.getCommonPartition(firstPartition, secondPartition);
		//		assert commonPartition != null;
		//		return commonPartition;
		if (firstPartition instanceof RootPartition) {
			return firstPartition;
		}
		else if (secondPartition instanceof RootPartition) {
			return secondPartition;
		}
		else {
			return loadingPartition;
		}
	}

	protected @NonNull Partition getMinimumDepthParentPartition(@NonNull Partition childPartition) {
		//		Partition minimumDepthParentPartition = scheduleCache.getMinimumDepthParentPartition(childPartition);
		//		assert minimumDepthParentPartition != null;
		//		return minimumDepthParentPartition;
		if (childPartition instanceof RootPartition) {
			return childPartition;
		}
		else if (childPartition instanceof LoadingPartition) {
			return rootPartition;
		}
		else {
			return loadingPartition;
		}
	}

	/**
	 * Install all connections so that the connection variable is declared at the common region and passed through all the
	 * intermediate regions between the common region and the regions that use the connection variable as a source or target.
	 */
	protected void installConnections() {
		List<@NonNull NodeConnection> connections = new ArrayList<>(connection2commonPartition.keySet());
		Collections.sort(connections, new Comparator<@NonNull NodeConnection>()		// impriive determinism
			{
			@Override
			public int compare(@NonNull NodeConnection o1, @NonNull NodeConnection o2) {
				List<@NonNull Integer> l1 = o1.getPasses();
				List<@NonNull Integer> l2 = o2.getPasses();
				int x1 = l1.size() > 0 ? l1.get(0) : -1;
				int x2 = l2.size() > 0 ? l2.get(0) : -1;
				return x1-x2;
			}
			});
		for (@NonNull NodeConnection connection : connections) {
			if (connection.isPassed()) {
				Partition commonPartition = connection2commonPartition.get(connection);
				assert commonPartition != null;
				List<@NonNull Partition> intermediatePartitions = new ArrayList<>();
				//				boolean isCyclic = rootRegion.isCyclicRootRegion();
				//				if (isCyclic) {		// FIXME should not be necessary
				//					intermediateRegions.add(rootRegion);
				//				}
				for (@NonNull Partition sourcePartition : scheduleCache.getSourcePartitions(connection)) {
					if (sourcePartition != commonPartition) { //|| sourceRegion.isCyclicRootRegion()) {
						Iterable<@NonNull Partition> sourcePartitions = Collections.singletonList(sourcePartition);
						installConnectionsLocateIntermediates(intermediatePartitions, sourcePartitions, commonPartition);
					}
				}
				for (@NonNull Partition targetPartition : scheduleCache.getTargetPartitions(connection)) {
					if ((targetPartition != commonPartition) && connection.isPassed(targetPartition)) {
						Iterable<@NonNull Partition> targetPartitions2 = /*targetRegion.isCyclicRootRegion() ? Collections.singletonList(targetRegion) :*/ connectionManager.getCallableParents(targetPartition);
						installConnectionsLocateIntermediates(intermediatePartitions, targetPartitions2, commonPartition);
					}
				}
				connection.setCommonPartition(commonPartition, intermediatePartitions);
				//				Scheduler.REGION_LOCALITY.println(connection + " => " + commonRegion + " " + intermediateRegions);
			}
		}
		for (@NonNull NodeConnection connection : connections) {
			if (connection.isPassed()) {
				Partition commonPartition = connection.getCommonPartition();
				assert commonPartition != null;
				Partition rootPartition = scheduleCache.getRootPartition();
				List<@NonNull Partition> intermediatePartitions = QVTscheduleUtil.getIntermediatePartitions(connection);
				for (@NonNull Partition intermediatePartition : intermediatePartitions) {
					Partition checkCommonPartition = connectionManager.getLoopingConnections(commonPartition).size() > 0 ? rootPartition : commonPartition;
					assert connectionManager.getLoopingConnections(commonPartition).size() > 0
					? Iterables.contains(connectionManager.getCallableParents(commonPartition), getCommonPartition(commonPartition, intermediatePartition))
						: getCommonPartition(commonPartition, intermediatePartition) == checkCommonPartition : "No common partition for " + connection;
				}
			}
		}
	}

	/**
	 * Recursively locate all the regions that are traversed as a call sub-tree rooted at commonRegion invokes each of callableParents.
	 */
	protected void installConnectionsLocateIntermediates(@NonNull List<@NonNull Partition> intermediatePartitions, @NonNull Iterable<@NonNull Partition> callableParents, @NonNull Partition commonPartition) {
		for (@NonNull Partition callableParent : callableParents) {
			if (callableParent != commonPartition) {
				if (!intermediatePartitions.contains(callableParent)) {
					intermediatePartitions.add(callableParent);
					installConnectionsLocateIntermediates(intermediatePartitions, connectionManager.getCallableParents(callableParent), commonPartition);
				}
			}
		}
	}

	/**
	 * Update the callStack so that region is at the top. Update connection2commonRegion so that all
	 * region's incomingConnections are accessible from a commonRegion on the callStack.
	 */
	protected void updateCallStack(@NonNull Stack<@NonNull Partition> callStack, @NonNull Partition partition) {
		QVTm2QVTs.REGION_STACK.println(partition + " => " + callStack);
		//
		//	Pop stack to commonRegion
		//
		Partition topOfStack = callStack.peek();
		assert topOfStack != null;
		Partition commonPartition = getCommonPartition(topOfStack, partition);
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
		/*		for (@NonNull Connection incomingConnection1 : scheduleCache.getIncomingConnections(region)) {		// FIXME passed
			for (@NonNull Region sourceRegion1 : scheduleCache.getSourceRegions(incomingConnection1)) {
				if (sourceRegion1.getLoopingConnections().size() > 0) {
					for (@NonNull Connection incomingConnection2 : scheduleCache.getIncomingConnections(sourceRegion1)) {		// FIXME passed
						for (@NonNull Region sourceRegion2 : scheduleCache.getSourceRegions(incomingConnection2)) {
							commonRegion = getCommonRegion(commonRegion, sourceRegion2);
						}
					}
				}
			}
		} */
		for (@NonNull Connection incomingConnection1 : scheduleCache.getIncomingConnections(partition)) {
			for (@NonNull Partition sourcePartition1 : scheduleCache.getSourcePartitions(incomingConnection1)) {
				//				if (sourceRegion1.getLoopingConnections().size() > 0) {
				for (@NonNull Connection incomingConnection2 : scheduleCache.getIncomingConnections(sourcePartition1)) {
					for (@NonNull Partition sourcePartition2 : scheduleCache.getSourcePartitions(incomingConnection2)) {
						commonPartition = getCommonPartition(commonPartition, sourcePartition2);
					}
				}
				//				}
			}
		}
		while (!callStack.contains(commonPartition)) {
			commonPartition = getMinimumDepthParentPartition(commonPartition);
			assert commonPartition != null;
		}
		while ((topOfStack != commonPartition) && (topOfStack != partition)) {
			callStack.pop();
			Partition topOfStack2 = callStack.peek();
			assert topOfStack2 != null;
			topOfStack = topOfStack2;
		}
		//
		//	Ensure that passed connections are hosted by a mutually common region.
		//
		//		Iterable<@NonNull Connection> incomingConnections = getIncomingConnections(region);
		//		assert incomingConnections != null;
		for (@NonNull Connection incomingConnection : scheduleCache.getIncomingConnections(partition)) {
			if (incomingConnection.isPassed(partition)) {
				commonPartition = updateConnectionLocality((@NonNull NodeConnection) incomingConnection, commonPartition);
			}
		}
		//		Iterable<@NonNull Connection> outgoingConnections = getOutgoingConnections(region);
		//		assert outgoingConnections != null;
		//		for (@NonNull Connection outgoingConnection : outgoingConnections) {
		//			if (outgoingConnection.isOutput()) {
		//				commonRegion = updateConnectionLocality((@NonNull NodeConnection) outgoingConnection, commonRegion);
		//			}
		//		}
		//
		//	Push stack to region (without re-traversing predecessors)
		//
		if (topOfStack != partition) {
			connectionManager.addCallToChild(topOfStack, partition);
			callStack.push(partition);
			topOfStack = partition;
		}
		assert topOfStack == callStack.peek();
		assert topOfStack == partition;
	}

	/**
	 * Update the connection-specific common-region of connection to be a common-region of commonStackRegion
	 * and all source and all target regions of connection.
	 */
	protected @NonNull Partition updateConnectionLocality(@NonNull NodeConnection connection, @NonNull Partition commonStackPartition) {
		assert connection.isPassed();
		Partition oldCommonPartition = connection2commonPartition.get(connection);
		@NonNull Partition commonPartition;
		if (oldCommonPartition == null) {
			commonPartition = commonStackPartition;
			for (@NonNull Partition sourcePartition : scheduleCache.getSourcePartitions(connection)) {
				commonPartition = getCommonPartition(commonPartition, sourcePartition);
			}
		}
		else {
			commonPartition = getCommonPartition(oldCommonPartition, commonStackPartition);
		}
		if (oldCommonPartition != commonPartition) {
			connection2commonPartition.put(connection, commonPartition);
		}
		return commonPartition;
	}
}