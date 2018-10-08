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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.LoadingPartition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.Partition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.RootPartition;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;

/**
 * ScheduleAnalysis analyses a sequence of concurrent partitions to identofy the necessary connections.
 */
public class ScheduleAnalysis
{
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull ConnectionManager connectionManager;

	/**
	 * The overall RootPartition.
	 */
	protected final @NonNull RootPartition rootPartition;

	/**
	 * All transitively callable partitions within the rootPartition.
	 */
	protected final @NonNull List<@NonNull Partition> allPartitions;

	private final @NonNull LoadingPartition loadingPartition;

	/**
	 * Cached list of all incoming connections per-region; excludes recursions.
	 */
	private final @NonNull Map<@NonNull Partition, @NonNull List<@NonNull Connection>> partition2incomingConnections = new HashMap<>();

	/**
	 * Cached list of all recursive/looping connections per-region.
	 */
	private final @NonNull Map<@NonNull Partition, @NonNull List<@NonNull Connection>> partition2loopingConnections = new HashMap<>();

	/**
	 * Cached list of all outgoing connections per-region; excludes recursions.
	 */
	private final @NonNull Map<@NonNull Partition, @NonNull List<@NonNull Connection>> partition2outgoingConnections = new HashMap<>();

	/**
	 * Cached list of all source regions per-connection and whether the source has unserviced content for the connection.
	 */
	private final @NonNull Map<@NonNull Connection, @NonNull List<@NonNull Partition>> connection2sourcePartitions = new HashMap<>();

	/**
	 * Cached list of all target regions per-connection and whether the connection has unserviced content for the target.
	 */
	private final @NonNull Map<@NonNull Connection, @NonNull List<@NonNull Partition>> connection2targetPartitions = new HashMap<>();

	/**
	 * The immediate source region of each incoming connection.
	 */
	//private final @NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> target2sources;

	/**
	 * The immediate source regions for each set of regions forming a cycle.
	 */
	//private final @NonNull Map<@NonNull Set<@NonNull Partition>, @NonNull Set<@NonNull Partition>> cycle2sources;

	/**
	 * The cycle in which each region may participate.
	 */
	//private final Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> partition2cycle;

	/**
	 * Depth in the call tree of each region. For the most part all source elements are at lower depth than target elements,
	 * however the call tree may have cycles which have the same depth throughout the cycle.
	 *
	 * FIXME this depth analysis has evolved from when scheduling made extensive use of MappingCalls. Now that
	 * Connections have been introduced, is the depth still useful and does it repeat some of the intervalIndex analysis?
	 */
	//private final @NonNull Map<@NonNull Partition, @NonNull Integer> partition2pass;

	/**
	 * The parents (invokers) of each region.
	 */
	//private final @NonNull Map<@NonNull Partition, @NonNull List<@NonNull Partition>> partition2parents;

	/**
	 * The regions that have no outgoing passed connections.
	 */
	// private final @NonNull Set<@NonNull Partition> unpassedPartitions = new HashSet<>();

	public ScheduleAnalysis(@NonNull ConnectionManager connectionManager, @NonNull RootPartition rootPartition) {
		this.scheduleManager = connectionManager.getScheduleManager();
		this.rootPartition = rootPartition;
		this.connectionManager = connectionManager;
		this.allPartitions = CompilerUtil.gatherPartitions(rootPartition, new ArrayList<>());
		Collections.sort(this.allPartitions, NameUtil.NAMEABLE_COMPARATOR);
		//
		// Initialize the incoming/looping/outgoing connection analyses of each region
		//
		LoadingPartition loadingPartition = null;
		for (@NonNull Partition partition : this.allPartitions) {
			analyzeConnections(partition);
			if (partition instanceof LoadingPartition) {
				assert loadingPartition == null;
				loadingPartition = (LoadingPartition) partition;
			}
		}
		assert loadingPartition != null;
		this.loadingPartition = loadingPartition;
		//
		// Initialize the source/target of each connection.
		// Compute the set of all connections that are not passed.
		//
		for (@NonNull Partition partition : this.allPartitions) {
			analyzeSourcesAndTargets(partition);
		}
		//
		//	Identify all the source regions for each target region.
		//
		//	this.target2sources = analyzeSources();
		//
		//	Identify all the cycles and their immedite sources.
		//
		//	this.cycle2sources = analyzeCycleSources();
		//
		//	Identify all the region that participate in cycles.
		//
		//	this.partition2cycle = analyzeCycleElements();
		//
		//	Determine the call tree depth of each connection / region.
		//
		//	this.partition2pass = analyzeDepths();
		//
		//	Determine the call tree parents of each region.
		//
		//	this.partition2parents = analyzeParents();
		//		System.out.println(toString());
	}

	/**
	 * Initialize the incoming/looping/outgoing connection analyses of each region
	 */
	private void analyzeConnections(@NonNull Partition partition) {
		List<@NonNull Connection> incomingConnections = new ArrayList<>();
		List<@NonNull Connection> loopingConnections = new ArrayList<>();
		List<@NonNull Connection> outgoingConnections = new ArrayList<>();
		for (@NonNull Connection connection : connectionManager.getIncomingConnections(partition)) {
			for (@NonNull Partition sourcePartition : connectionManager.getSourcePartitions(connection)) {
				if (partition == sourcePartition) {
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
		for (@NonNull Connection connection : connectionManager.getNextConnections(partition)) {
			for (@NonNull Partition targetPartition : connectionManager.getTargetPartitions(connection)) {
				if (partition == targetPartition) {
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
		partition2incomingConnections.put(partition, incomingConnections);
		partition2loopingConnections.put(partition, loopingConnections);
		partition2outgoingConnections.put(partition, outgoingConnections);
	}

	//
	//	Determine the cycles and their sources.
	//
	/*	private @NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> analyzeCycleElements() {
		Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> partition2cycle = new HashMap<>();
		for (@NonNull Set<@NonNull Partition> cycle : cycle2sources.keySet()) {
			for (@NonNull Partition partition : cycle) {
				partition2cycle.put(partition, cycle);
			}
		}
		return partition2cycle;
	} */

	//
	//	Determine the cycles and their sources.
	//
	/*	private @NonNull Map<@NonNull Set<@NonNull Partition>, @NonNull Set<@NonNull Partition>> analyzeCycleSources() {
		Map<@NonNull Set<@NonNull Partition>, @NonNull Set<@NonNull Partition>> cycle2sources = new HashMap<>();
		Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> target2sourcesClosure = CompilerUtil.computeClosure(target2sources);
		Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> source2targetsClosure = CompilerUtil.computeInverseClosure(target2sourcesClosure);
		for (@NonNull Partition partition : allPartitions) {
			Set<@NonNull Partition> sourcePartitions = target2sourcesClosure.get(partition);
			Set<@NonNull Partition> targetPartitions = source2targetsClosure.get(partition);
			assert (sourcePartitions != null) && (targetPartitions != null);
			Set<@NonNull Partition> cyclicPartitions = new HashSet<>(sourcePartitions);
			cyclicPartitions.retainAll(targetPartitions);
			if (!cyclicPartitions.isEmpty() && !cycle2sources.containsKey(cyclicPartitions)) {
				Set<@NonNull Partition> cycleSources = new HashSet<>();
				for (@NonNull Partition cyclicPartition : cyclicPartitions) {
					Set<@NonNull Partition> sources = target2sources.get(cyclicPartition);
					assert sources != null;
					cycleSources.addAll(sources);
				}
				cycleSources.removeAll(cyclicPartitions);
				cycle2sources.put(cyclicPartitions, cycleSources);
			}
		}
		return cycle2sources;
	} */

	/*	private @NonNull Map<@NonNull Partition, @NonNull Integer> analyzeDepths() {
		//
		//	Loop to allocate connection/node element to each depth so that each element has as few sources at greater depth.
		//
		Map<@NonNull Partition, @NonNull Integer> partition2pass = new HashMap<>();
		Set<@NonNull Partition> allPartitions = new HashSet<>(target2sources.keySet());
		//	Set<@NonNull Partition> pendingPartitions = new HashSet<>(allRegions);
		Set<@NonNull Partition> pendingPartitions = new HashSet<>();
		for (@NonNull Partition partition : allPartitions) {
			pendingPartitions.add(partition);
		}
		//	Set<@NonNull Set<@NonNull Partition>> pendingCycles = new HashSet<>(cycle2sources.keySet());
		Set<@NonNull Set<@NonNull Partition>> pendingCycles = new HashSet<>();
		for (@NonNull Set<@NonNull Partition> partitions : cycle2sources.keySet()) {
			Set<@NonNull Partition> cycle = new HashSet<>();
			for (@NonNull Partition partition : partitions) {
				cycle.add(partition);
			}
			pendingCycles.add(cycle);
		}
		partition2pass.put(rootPartition, 0);
		for (int depth = 1; !pendingPartitions.isEmpty(); depth++) {
			Set<@NonNull Partition> readyPartitions = new HashSet<>(partition2pass.keySet());
			Set<@NonNull Partition> nowReadyPartitions = new HashSet<>();
			Set<@NonNull Set<@NonNull Partition>> nowReadyCycles = new HashSet<>();
			for (@NonNull Partition targetPartition : pendingPartitions) {
				Set<@NonNull Partition> targetSourcePartitions = new HashSet<>(target2sources.get(targetPartition));
				assert targetSourcePartitions != null;
				targetSourcePartitions.removeAll(readyPartitions);
				if (targetSourcePartitions.isEmpty()) {
					nowReadyPartitions.add(targetPartition);
				}
			}
			for (@NonNull Set<@NonNull Partition> targetCycle : pendingCycles) {
				Set<@NonNull Partition> targetSourcePartitions = new HashSet<>(cycle2sources.get(targetCycle));
				assert targetSourcePartitions != null;
				targetSourcePartitions.removeAll(readyPartitions);
				if (targetSourcePartitions.isEmpty()) {
					nowReadyPartitions.addAll(targetCycle);
					nowReadyCycles.add(targetCycle);
				}
			}
			if (nowReadyPartitions.size() > 0) {			// one or more elements has all sources at lower depths.
				for (@NonNull Partition nowReadyPartition : nowReadyPartitions) {
					partition2pass.put(nowReadyPartition, depth);
					pendingPartitions.remove(nowReadyPartition);
				}
				pendingCycles.removeAll(nowReadyCycles);
			}
			else {										// else choose an elements with fewest greater depth sources.
				Partition fewestBadSourcePartition = null;
				int badSources = Integer.MAX_VALUE;
				for (@NonNull Partition targetPartition : pendingPartitions) {
					Set<@NonNull Partition> targetSourcePartitions = new HashSet<>(target2sources.get(targetPartition));
					assert targetSourcePartitions != null;
					targetSourcePartitions.removeAll(readyPartitions);
					int targetSourceElementsSize = targetSourcePartitions.size();
					if ((fewestBadSourcePartition == null) || (targetSourceElementsSize < badSources)) {
						badSources = targetSourceElementsSize;
						fewestBadSourcePartition = targetPartition;
					}
				}
				assert fewestBadSourcePartition != null;
				partition2pass.put(fewestBadSourcePartition, depth);
				pendingPartitions.remove(fewestBadSourcePartition);
			}
		}
		return partition2pass;
	} */

	/*	private @NonNull Map<@NonNull Partition, @NonNull List<@NonNull Partition>> analyzeParents() {
		Map<@NonNull Partition, @NonNull List<@NonNull Partition>> partition2parents = new HashMap<>();
		partition2parents.put(rootPartition, Collections.emptyList());
		for (@NonNull Partition targetPartition : allPartitions) {
			Set<@NonNull Partition> parentSet = new HashSet<>();
			Set<@NonNull Partition> sourcePartitions = target2sources.get(targetPartition);
			assert sourcePartitions != null;
			for (@NonNull Partition sourcePartition : sourcePartitions) {
				Set<@NonNull Partition> sourceCycle = partition2cycle.get(sourcePartition);
				if (sourceCycle != null) {
					Set<@NonNull Partition> cycleSources = cycle2sources.get(sourceCycle);
					assert cycleSources != null;
					parentSet.addAll(cycleSources);
				}
				else {
					parentSet.add(sourcePartition);
				}
			}
			if (parentSet.isEmpty()) {
				parentSet.add(rootPartition);
			}
			List<@NonNull Partition> parentList = new ArrayList<>(parentSet);
			Collections.sort(parentList, NameUtil.NAMEABLE_COMPARATOR);
			partition2parents.put(targetPartition, parentList);
		}
		return partition2parents;
	} */

	/**
	 * Initialize the source/target content of each connection of each region to empty.
	 * Compute the set of all connections that are not passed.
	 * Compute the set of all regions that are blocked by a mandatory dependence.
	 */
	private void analyzeSourcesAndTargets(@NonNull Partition partition) {
		//	boolean hasPassedConnection = false;
		//	for (@NonNull Connection connection : getOutgoingConnections(partition)) {
		//		if (connection.isPassed()) {
		//			hasPassedConnection = true;
		//			break;
		//		}
		//	}
		// (!hasPassedConnection) {
		//		unpassedPartitions.add(partition);
		//	}
		for (@NonNull Connection connection : getIncomingConnections(partition)) {
			List<@NonNull Partition> sourcePartitions = connection2sourcePartitions.get(connection);
			if (sourcePartitions == null) {
				sourcePartitions = new ArrayList<>();
				for (@NonNull Partition sourcePartition : connectionManager.getSourcePartitions(connection)) {
					if (!sourcePartitions.contains(sourcePartition)) {
						sourcePartitions.add(sourcePartition);
					}
				}
				connection2sourcePartitions.put(connection, sourcePartitions);
			}
			List<@NonNull Partition> targetPartitions = connection2targetPartitions.get(connection);
			if (targetPartitions == null) {
				targetPartitions = new ArrayList<>();
				for (@NonNull Partition targetPartition : connectionManager.getTargetPartitions(connection)) {
					if (!targetPartitions.contains(targetPartition)) {
						targetPartitions.add(targetPartition);
					}
				}
				connection2targetPartitions.put(connection, targetPartitions);
			}
		}
	}

	//
	//	Identify all the source regions for each target region.
	//
	private @NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> analyzeSources() {
		Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> target2sources = new HashMap<>();
		for (@NonNull Partition partition : allPartitions) {
			target2sources.put(partition, new HashSet<>());
		}
		for (@NonNull Partition partition : allPartitions) {
			Set<@NonNull Partition> sources = new HashSet<>();
			target2sources.put(partition, sources);
			List<@NonNull Connection> incomingConnections = partition2incomingConnections.get(partition);
			//			List<@NonNull Connection> loopingConnections = region2loopingConnections.get(region);
			//			List<@NonNull Connection> outgoingConnections = region2outgoingConnections.get(region);
			assert incomingConnections != null;
			for (@NonNull Connection incomingConnection : incomingConnections) {
				List<@NonNull Partition> sourcePartitions = connection2sourcePartitions.get(incomingConnection);
				assert sourcePartitions != null;
				sources.addAll(sourcePartitions);
			}
		}
		return target2sources;
	}

	protected void buildCallTree(@NonNull Iterable<@NonNull ? extends Iterable<@NonNull Partition>> partitionSchedule) {
		CallTreeBuilder callTreeBuilder = new CallTreeBuilder(this);
		callTreeBuilder.buildTree(rootPartition, partitionSchedule);
	}

	public @NonNull ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	protected @NonNull Iterable<? extends @NonNull Connection> getConnections() {
		return connection2targetPartitions.keySet();
	}

	protected @NonNull Iterable<@NonNull Connection> getIncomingConnections(@NonNull Partition partition) {
		List<@NonNull Connection> incomingConnections = partition2incomingConnections.get(partition);
		assert incomingConnections != null;
		return incomingConnections;
	}

	public @NonNull Partition getLoadingPartition() {
		return loadingPartition;
	}

	protected @NonNull Iterable<@NonNull Connection> getLoopingConnections(@NonNull Partition partition) {
		List<@NonNull Connection> loopingConnections = partition2loopingConnections.get(partition);
		assert loopingConnections != null;
		return loopingConnections;
	}

	protected @NonNull Iterable<@NonNull Connection> getOutgoingConnections(@NonNull Partition partition) {
		List<@NonNull Connection> outgoingConnections = partition2outgoingConnections.get(partition);
		assert outgoingConnections != null;
		return outgoingConnections;
	}

	public @NonNull RootPartition getRootPartition() {
		return rootPartition;
	}

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	protected @NonNull Iterable<@NonNull Partition> getSourcePartitions(@NonNull Connection connection) {
		List<@NonNull Partition> sourceRegions = connection2sourcePartitions.get(connection);
		assert sourceRegions != null;
		return sourceRegions;
	}

	protected @NonNull Iterable<@NonNull Partition> getTargetPartitions(@NonNull Connection connection) {
		List<@NonNull Partition> targetPartitions = connection2targetPartitions.get(connection);
		assert targetPartitions != null;
		return targetPartitions;
	}

	private void propagateIndexes(@NonNull Connection connection) {
		List<@NonNull Integer> connectionIndexes = connection.getPasses();
		//	assert connectionIndexes.size() > 0;
		if (connectionIndexes.size() > 0) {			// Empty for dead inputs
			for (@NonNull Partition partition : getTargetPartitions(connection)) {
				int invocationIndex = partition.getFirstPass();
				boolean propagateThroughRegion = false;
				for (int connectionIndex : connectionIndexes) {
					if ((connectionIndex > invocationIndex) && partition.addPass(connectionIndex)) {
						propagateThroughRegion = true;
					}
				}
				if (propagateThroughRegion) {
					Iterable<@NonNull Connection> outgoingConnections = getOutgoingConnections(partition);
					for (@NonNull Connection targetConnection : outgoingConnections) {
						boolean propagateThroughConnection = false;
						for (int connectionIndex : connectionIndexes) {
							if (targetConnection.addPass(connectionIndex)) {
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

	public void schedule(@NonNull RootPartition rootPartition, @NonNull Iterable<@NonNull ? extends Iterable<@NonNull Partition>> partitionSchedule) {
		int depth = 0;
		for (@NonNull Iterable<@NonNull Partition> concurrency : partitionSchedule) {
			for (@NonNull Partition partition : concurrency) {
				partition.setPass(depth);
				Iterable<@NonNull Connection> loopingConnections = getLoopingConnections(partition);
				assert loopingConnections != null;
				Iterable<@NonNull Connection> outgoingConnections = getOutgoingConnections(partition);
				assert outgoingConnections != null;
				for (@NonNull Connection loopingConnection : loopingConnections) {
					loopingConnection.addPass(depth);
				}
				for (@NonNull Connection outgoingConnection : outgoingConnections) {
					outgoingConnection.addPass(depth);
				}
			}
			depth++;
		}
		scheduleManager.writeDebugGraphs("6-pass", false, true, false);
		/**
		 * Propagate the additional connection indexes to their outgoing connections.
		 */
		for (@NonNull Connection connection : getConnections()) {
			propagateIndexes(connection);
		}
		scheduleManager.writeDebugGraphs("7-passes", false, true, false);
		buildCallTree(partitionSchedule);
	}

	@Override
	public @NonNull String toString() {
		StringBuilder s = new StringBuilder();
		List<@NonNull Partition> list = new ArrayList<>(allPartitions);
		Collections.sort(list, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull Partition entry : list) {
			if (s.length() > 0) {
				s.append("\n");
			}
			s.append(entry.getPassRangeText() + " : " + entry.getName());
		}
		return s.toString();
	}
}