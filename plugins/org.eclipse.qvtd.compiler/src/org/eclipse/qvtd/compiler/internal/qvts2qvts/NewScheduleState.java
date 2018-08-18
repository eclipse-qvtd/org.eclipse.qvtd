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

import java.util.Collection;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.RootPartition;
import org.eclipse.qvtd.pivot.qvtschedule.DatumConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;

/**
 * ScheduleCache provides the working state used during the schedule index allocation.
 */
public class NewScheduleState extends ScheduleCache
{
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull RootPartition rootPartition;

	public NewScheduleState(@NonNull ScheduleManager scheduleManager, @NonNull RootPartition rootPartition) {
		super(rootPartition.getScheduledRegion());
		this.scheduleManager = scheduleManager;
		this.rootPartition = rootPartition;
	}

	protected void buildCallTree() {
		CallTreeBuilder callTreeBuilder = new CallTreeBuilder(this);
		callTreeBuilder.buildTree(scheduledRegion, rootPartition.getRegionSchedule());
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

	public void schedule(@NonNull RootPartition rootPartition) {
		ScheduledRegion rootScheduledRegion = rootPartition.getScheduledRegion();
		int depth = 0;
		//		LoadingRegion loadingRegion = rootScheduledRegion.getOwnedLoadingRegion();
		//		if (loadingRegion != null) {
		//			loadingRegion.addIndex(depth++);
		//		}
		for (@NonNull Collection<@NonNull Region> concurrency : rootPartition.getRegionSchedule()) {
			for (@NonNull Region region : concurrency) {
				region.addIndex(depth);
				Iterable<@NonNull DatumConnection<?>> loopingConnections = getLoopingConnections(region);
				assert loopingConnections != null;
				Iterable<@NonNull DatumConnection<?>> outgoingConnections = getOutgoingConnections(region);
				assert outgoingConnections != null;
				//	Set<@NonNull Region> nextRegions = new HashSet<>();
				for (@NonNull DatumConnection<?> loopingConnection : loopingConnections) {
					loopingConnection.addIndex(depth);
				}
				for (@NonNull DatumConnection<?> outgoingConnection : outgoingConnections) {
					outgoingConnection.addIndex(depth);
				}
			}
			depth++;
		}
		//		scheduleScheduledRegion(rootScheduledRegion);
		scheduleManager.writeDebugGraphs("6-indexed", false, true, true);
		/**
		 * Propagate the additional connection indexes to their outgoing connections.
		 */
		for (@NonNull DatumConnection<?> connection : getConnections()) {
			propagateIndexes(connection);
		}
		buildCallTree();
	}

	//	protected abstract void scheduleScheduledRegion(@NonNull ScheduledRegion scheduledRegion);
}