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
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionedTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.RootPartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.RootPartition;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Sets;

/**
 * ScheduleAnalysis analyses a sequence of concurrent partitions to identofy the necessary connections.
 */
public class ScheduleAnalysis
{
	protected final @NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis;
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull ConnectionManager connectionManager;

	/**
	 * The overall RootPartition.
	 */
	protected final @NonNull RootPartitionAnalysis rootPartitionAnalysis;

	/**
	 * All transitively callable partitions within the rootPartition.
	 */
	protected final @NonNull List<@NonNull PartitionAnalysis> allPartitionAnalyses;

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
	 * @param partitionedTransformationAnalysis
	 */
	// private final @NonNull Set<@NonNull Partition> unpassedPartitions = new HashSet<>();

	public ScheduleAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull ConnectionManager connectionManager, @NonNull RootPartitionAnalysis rootPartitionAnalysis) {
		this.partitionedTransformationAnalysis = partitionedTransformationAnalysis;
		this.scheduleManager = connectionManager.getScheduleManager();
		this.rootPartitionAnalysis = rootPartitionAnalysis;
		this.connectionManager = connectionManager;
		this.allPartitionAnalyses = CompilerUtil.gatherPartitionAnalyses(rootPartitionAnalysis, new ArrayList<>());
		Collections.sort(this.allPartitionAnalyses, NameUtil.NAMEABLE_COMPARATOR);
		//
		// Initialize the incoming/looping/outgoing connection analyses of each region
		//
		LoadingPartition loadingPartition = null;
		for (@NonNull PartitionAnalysis partitionAnalysis : this.allPartitionAnalyses) {
			analyzeConnections(partitionAnalysis);
			Partition partition = partitionAnalysis.getPartition();
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
		for (@NonNull PartitionAnalysis partitionAnalysis : this.allPartitionAnalyses) {
			analyzeSourcesAndTargets(partitionAnalysis.getPartition());
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
	private void analyzeConnections(@NonNull PartitionAnalysis partitionAnalysis) {
		Partition partition = partitionAnalysis.getPartition();
		List<@NonNull Connection> incomingConnections = new ArrayList<>();
		List<@NonNull Connection> loopingConnections = new ArrayList<>();
		List<@NonNull Connection> outgoingConnections = new ArrayList<>();
		for (@NonNull Connection connection : connectionManager.getIncomingConnections(partitionAnalysis)) {
			for (@NonNull Partition sourcePartition : connection.getSourcePartitions()) {
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
			for (@NonNull Partition targetPartition : connection.getTargetPartitions()) {
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
				for (@NonNull Partition sourcePartition : connection.getSourcePartitions()) {
					if (!sourcePartitions.contains(sourcePartition)) {
						sourcePartitions.add(sourcePartition);
					}
				}
				connection2sourcePartitions.put(connection, sourcePartitions);
			}
			List<@NonNull Partition> targetPartitions = connection2targetPartitions.get(connection);
			if (targetPartitions == null) {
				targetPartitions = new ArrayList<>();
				for (@NonNull Partition targetPartition : connection.getTargetPartitions()) {
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
	/*
	private @NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> analyzeSources() {
		Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> target2sources = new HashMap<>();
		for (@NonNull PartitionAnalysis partitionAnalysis : allPartitionAnalyses) {
			target2sources.put(partitionAnalysis.getPartition(), new HashSet<>());
		}
		for (@NonNull PartitionAnalysis partitionAnalysis : allPartitionAnalyses) {
			Partition partition = partitionAnalysis.getPartition();
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
	} */

	protected void buildCallTree(@NonNull Iterable<@NonNull Concurrency> partitionSchedule) {
		CallTreeBuilder callTreeBuilder = new CallTreeBuilder(this, rootPartitionAnalysis.getPartition(), loadingPartition);
		callTreeBuilder.buildTree(partitionSchedule);
	}

	private void checkPassNumbers(@NonNull Connection connection) {
		@SuppressWarnings("unused") int firstPass = connection.getFirstPass();
		int lastPass = connection.getLastPass();
		for (@NonNull Partition sourcePartition : connection.getSourcePartitions()) {
			//	assert sourcePartition.getFirstPass() <= firstPass;
			assert sourcePartition.getLastPass() <= lastPass;
		}
		for (@NonNull Partition targetPartition : connection.getTargetPartitions()) {
			//	boolean isCyclic = false;
			//	for (EObject eObject = targetPartition; eObject instanceof Partition; eObject = eObject.eContainer()) {
			//		if (eObject instanceof CyclicPartition) {
			//			isCyclic = true;
			//			break;
			//		}
			//	}
			//	if (isCyclic) {
			//	assert firstPass <= targetPartition.getFirstPass();
			assert lastPass <= targetPartition.getLastPass();
			//	}
			//	else {
			//		assert firstPass < targetPartition.getFirstPass();
			//		assert lastPass < targetPartition.getLastPass();
			//	}
		}
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
		return rootPartitionAnalysis.getPartition();
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

	private void propagatePassNumbers(@NonNull Partition sourcePartition, @NonNull Set<@NonNull Connection> changedConnections) {
		Iterable<@NonNull Integer> sourcePasses = QVTscheduleUtil.getPasses(sourcePartition);
		for (@NonNull Connection outgoingConnection : getOutgoingConnections(sourcePartition)) {
			boolean isChanged = false;
			for (int sourcePass : sourcePasses) {
				if (outgoingConnection.addPass(sourcePass)) {
					isChanged = true;
				}
			}
			if (isChanged) {
				changedConnections.add(outgoingConnection);
			}
		}
	}

	private void propagatePassNumbers(@NonNull Connection incomingConnection, @NonNull Set<@NonNull Partition> changedPartitions) {
		List<@NonNull Integer> connectionPasses = incomingConnection.getPasses();
		for (@NonNull Partition targetPartition : getTargetPartitions(incomingConnection)) {
			boolean isChanged = false;
			int lastPass = targetPartition.getLastPass();
			for (int connectionPass : connectionPasses) {
				if ((connectionPass > lastPass) && targetPartition.addPass(connectionPass)) {
					isChanged = true;
				}
			}
			if (isChanged) {
				changedPartitions.add(targetPartition);
			}
		}
	}

	public void schedule(@NonNull RootPartition rootPartition, @NonNull List<@NonNull Concurrency> partitionSchedule) {
		int passNumber = 0;
		int cycleDepth = 0;
		int cycleStart = 0;
		Set<@NonNull Partition> changedPartitions = new HashSet<>();
		for (@NonNull Concurrency concurrency : partitionSchedule) {
			concurrency.setPass(passNumber);
			if (concurrency.isCycleStart()) {
				cycleDepth++;
				if (cycleDepth == 1) {
					cycleStart = passNumber;
				}
			}
			for (@NonNull PartitionAnalysis partitionAnalysis : concurrency) {
				Partition partition = partitionAnalysis.getPartition();
				changedPartitions.add(partition);
				Iterable<@NonNull Connection> loopingConnections = getLoopingConnections(partition);
				assert loopingConnections != null;
				for (@NonNull Connection loopingConnection : loopingConnections) {
					loopingConnection.addPass(passNumber);
				}
			}
			if (concurrency.isCycleEnd()) {
				cycleDepth--;
				if (cycleDepth == 0) {
					for (int cyclePass = cycleStart; cyclePass < passNumber; cyclePass++) {
						partitionSchedule.get(cyclePass).addPass(passNumber);
					}
				}
			}
			passNumber++;
		}
		assert cycleDepth == 0;
		scheduleManager.writeDebugGraphs("6-pass", false, true, false);
		/**
<<<<<<< Upstream, based on master
		 * Propagate the partition passnumbers through their outgoing connections.
=======
		 * Ensure connection responds to all sources.
		 */
		for (@NonNull Connection connection : getConnections()) {
			for (@NonNull Partition sourcePartition : getSourcePartitions(connection)) {
				for (int sourcePass : sourcePartition.getPasses()) {
					connection.addPass(sourcePass);
				}
			}
		}
		/**
		 * Propagate the additional connection indexes to their outgoing connections.
>>>>>>> a70c1c9 wip
		 */
		Set<@NonNull Connection> changedConnections = Sets.newHashSet(getConnections());
		while (!changedPartitions.isEmpty()) {
			for (@NonNull Partition changedPartition : changedPartitions) {
				propagatePassNumbers(changedPartition, changedConnections);
			}
			changedPartitions.clear();
			for (@NonNull Connection changedConnection : changedConnections) {
				propagatePassNumbers(changedConnection, changedPartitions);
			}
			changedConnections.clear();
		}
		scheduleManager.writeDebugGraphs("7-passes", false, true, false);
		for (@NonNull Connection connection : getConnections()) {
			checkPassNumbers(connection);
		}
		buildCallTree(partitionSchedule);
	}

	@Override
	public @NonNull String toString() {
		StringBuilder s = new StringBuilder();
		List<@NonNull PartitionAnalysis> list = new ArrayList<>(allPartitionAnalyses);
		Collections.sort(list, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull PartitionAnalysis entry : list) {
			if (s.length() > 0) {
				s.append("\n");
			}
			s.append(entry.getPartition().getPassRangeText() + " : " + entry.getName());
		}
		return s.toString();
	}
}